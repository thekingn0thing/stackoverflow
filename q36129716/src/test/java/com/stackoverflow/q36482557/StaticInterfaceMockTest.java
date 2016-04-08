package com.stackoverflow.q36482557;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.powermock.modules.junit4.repacked.CustomPowerMockRunner;

import java.net.ServerSocket;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

// need custom PowerMockRunner to add custom MockTransformer which will transform interfaces
@RunWith(CustomPowerMockRunner.class)
@PowerMockRunnerDelegate(VertxUnitRunner.class)
@PrepareForTest({MongoClient.class, StaticServiceInterface.class, ServiceInterface.class, ServiceInterfaceWithDefault.class})
public class StaticInterfaceMockTest {

    @Mock
    ServiceInterface serviceInterface;

    @Mock
    ServiceInterfaceWithDefault serviceInterfaceWithDefault;

    @Mock
    private MongoClient mongo;

    private Vertx vertx;
    private Integer port;


    @Before
    public void setUp(TestContext context) throws Exception {
        vertx = Vertx.vertx();

        mockStatic(MongoClient.class);

        when(MongoClient.createShared(any(), any())).thenReturn(mongo);

        ServerSocket socket = new ServerSocket(0);
        port = socket.getLocalPort();
        socket.close();

        DeploymentOptions options = new DeploymentOptions().setConfig(new JsonObject().put("http.port", port));
        //vertx.deployVerticle(TalWebVerticle.class.getName(), options, context.asyncAssertSuccess());
    }

    @Test
    public void testMongoClient() throws Exception {
        assertEquals(mongo, MongoClient.createShared(null, null));
    }

    @Test
    public void testStaticCallInterface() throws Exception {
        mockStatic(StaticServiceInterface.class);

        final String value = "Static Mock Works";
        when(StaticServiceInterface.say(anyString())).thenReturn(value);

        assertEquals(value, StaticServiceInterface.say(""));
    }

    @Test
    public void testCallInterface() throws Exception {
        final String value = "Interface Mock Works";
        when(serviceInterface.say(anyString())).thenReturn(value);

        assertEquals(value, serviceInterface.say(""));
    }

    @Test
    public void testCallInterfaceWithDefault() throws Exception {
        final String value = "Interface default method Mock Works";
        when(serviceInterfaceWithDefault.say(anyString())).thenReturn(value);

        assertEquals(value, serviceInterfaceWithDefault.say(""));
    }

}