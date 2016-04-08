package com.stackoverflow.q36394482;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 *
 */
@RunWith(PowerMockRunner.class)

public class KeyStoreTest {

    private SignatureUtilImpl signatureUtil = new SignatureUtilImpl();

    @PrepareForTest({KeyStoreFactory.class, SignatureUtilImpl.class})
    @Test
    public void should_verify_signature_when_verifySignature_called_with_fileName_and_certificate_details_in_verifySignature_method() throws Exception {
        CMSSignedDataParser spMock = PowerMockito.mock(CMSSignedDataParser.class);
        SignerInformationVerifier verifierMock = Mockito.mock(SignerInformationVerifier.class);
        SignatureUtilImpl signatureUtilSpy = Mockito.spy(new SignatureUtilImpl());
        KeyStore keyStoreMock = PowerMockito.mock(KeyStore.class);
        PowerMockito.mockStatic(KeyStoreFactory.class);
        PowerMockito.when(KeyStoreFactory.getInstance(anyString(), anyString())).thenReturn(keyStoreMock);
        SignerInformation signerInformationMock = Mockito.mock(SignerInformation.class);
        Collection<SignerInformation> collection = new ArrayList();
        collection.add(signerInformationMock);

        Mockito.doCallRealMethod().when(signatureUtilSpy).verifySignature("src/test/java/Updates.zip.signed.pkcs7"
                , "src/test/java/Updates-retrieved.zip", "Windows-MY,SunMSCAPI,someName");
        Mockito.doNothing().when(signatureUtilSpy).loadKeyStore();
        Mockito.doReturn(verifierMock).when(signatureUtilSpy).getSignerInformationVerifier(anyString(), anyString());
        Mockito.doReturn(spMock).when(signatureUtilSpy).getDataParser(any(DigestCalculatorProvider.class), any(FileInputStream.class));
        Mockito.doReturn(collection).when(spMock).getSignerInfos();
        Mockito.doReturn(true).when(signerInformationMock).verify(verifierMock);

        boolean result = signatureUtilSpy.verifySignature("src/test/java/Updates.zip.signed.pkcs7"
                , "src/test/java/Updates-retrieved.zip", "Windows-MY,SunMSCAPI,someName");
        Assert.assertTrue(result);
    }


}
