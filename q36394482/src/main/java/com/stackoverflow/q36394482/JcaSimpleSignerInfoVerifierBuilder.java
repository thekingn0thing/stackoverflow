package com.stackoverflow.q36394482;

import java.security.cert.X509Certificate;

/**
 *
 */
public class JcaSimpleSignerInfoVerifierBuilder {
    private String provider;

    public JcaSimpleSignerInfoVerifierBuilder setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public SignerInformationVerifier build(X509Certificate certificate) {
        return new SignerInformationVerifier();
    }
}
