package com.stackoverflow.q36394482;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchProviderException;

/**
 *
 */
public class KeyStoreFactory {
    public static KeyStore getInstance(String typeOfCertificateStore, String certificateStoreProvider){
        try {
            return KeyStore.getInstance(typeOfCertificateStore, certificateStoreProvider);
        } catch (KeyStoreException | NoSuchProviderException e) {
            return null;
        }
    }
}

