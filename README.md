# Spring cloud demo

How to generate key store with keytool:
keytool -genkeypair -alias mytestkey -keyalg RSA \
-dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US" \
-keypass changeme -keystore server.jks -storepass letmein \
-validity 365

put the file server.jks to resource directory of config server.

then the config will be:
encrypt.key-store.location=classpath:/server.jks
encrypt.key-store.password=letmein
encrypt.key-store.alias=mytestkey
encrypt.key-store.secret=changeme
