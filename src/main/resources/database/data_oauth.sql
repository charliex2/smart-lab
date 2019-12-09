INSERT INTO `oauth_client_details`
VALUES ('dev', '', 'test', 'app', 'password,client_credentials,authorization_code,refresh_token', 'http://www.baidu.com',
        '', 3600, 3600, '{\"country\":\"CN\",\"country_code\":\"086\"}', 'false');

INSERT INTO oauth_client_details(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
VALUES ('spring-security-oauth2-read-client', 'resource-server-rest-api',
           /*spring-security-oauth2-read-client-password1234*/'$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km',
        'read', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);
INSERT INTO oauth_client_details(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
VALUES ('spring-security-oauth2-read-write-client', 'resource-server-rest-api',
           /*spring-security-oauth2-read-write-client-password1234*/'$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W',
        'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

# INSERT INTO AUTHORITY(ID, NAME) VALUES (1, 'COMPANY_CREATE');
# INSERT INTO AUTHORITY(ID, NAME) VALUES (2, 'COMPANY_READ');
# INSERT INTO AUTHORITY(ID, NAME) VALUES (3, 'COMPANY_UPDATE');
# INSERT INTO AUTHORITY(ID, NAME) VALUES (4, 'COMPANY_DELETE');
# INSERT INTO AUTHORITY(ID, NAME) VALUES (5, 'DEPARTMENT_CREATE');
# INSERT INTO AUTHORITY(ID, NAME) VALUES (6, 'DEPARTMENT_READ');
# INSERT INTO AUTHORITY(ID, NAME) VALUES (7, 'DEPARTMENT_UPDATE');
# INSERT INTO AUTHORITY(ID, NAME) VALUES (8, 'DEPARTMENT_DELETE');