package com.stackoverflow.q36394482;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 *
 */
public class SignatureUtilImpl {
    public boolean verifySignature(String filePath, String extractContentsPath, String csvParams)
            throws ServiceSDKException {
        boolean result = false;
        String typeOfCertificateStore = "";
        String certificateStoreProvider = "";
        String certificateName = "";
        SignerInformationVerifier verifier = null;
        if (filePath != null && extractContentsPath != null && csvParams != null && !filePath.isEmpty()
                && !extractContentsPath.isEmpty() && !csvParams.isEmpty()) {

            try {
                String[] receivedParams = csvParams.split(",");
                typeOfCertificateStore = receivedParams[0];
                certificateStoreProvider = receivedParams[1];
                certificateName = receivedParams[2];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ServiceSDKException("csvParams should have type of certificate store, certificate store provider and certificate name respectively", e);
            }

            try {
                Path signedDataFilePath = Paths.get(filePath);
                Path pathToExtractContents = Paths.get(extractContentsPath);

                KeyStore msCertStore = KeyStoreFactory.getInstance(typeOfCertificateStore, certificateStoreProvider);
                msCertStore.load(null, null);
                try {
                    verifier = new JcaSimpleSignerInfoVerifierBuilder()
                            .setProvider(certificateStoreProvider)
                            .build(((X509Certificate) msCertStore.getCertificate(certificateName)));
                } catch (Exception e) {
                    throw new ServiceSDKException("Exception occurred when building certificate",e);
                }
                verify(signedDataFilePath, pathToExtractContents, verifier);
                result = true;
            } catch (IOException | NoSuchAlgorithmException
                    | CertificateException e) {
                result = false;
                throw new ServiceSDKException("Exception occurred while preparing to verify signature " , e);
            }
        } else {
            throw new ServiceSDKException("FilePath,extract contents path or csv params cannot be empty or null");
        }
        return result;
    }

    private void verify(Path signedDataFilePath, Path pathToExtractContents, SignerInformationVerifier verifier) {

    }

    public void loadKeyStore() {
        throw new RuntimeException("Test failed.");
    }

    public SignerInformationVerifier getSignerInformationVerifier(String s, String s1) {
        return new SignerInformationVerifier();
    }

    public CMSSignedDataParser getDataParser(DigestCalculatorProvider any, FileInputStream any1) {
        return new CMSSignedDataParser();
    }
}
