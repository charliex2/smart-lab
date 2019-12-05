INSERT INTO users (id, username, password)
VALUES (1, 'user', 'e10adc3949ba59abbe56e057f20f883e');
 INSERT INTO user (id, username, password)
VALUES (2, 'admin', 'e10adc3949ba59abbe56e057f20f883e');

INSERT INTO roles (id, name)
VALUES (1, 'USER');
INSERT INTO roles (id, name)
VALUES (2, 'ADMIN');

INSERT INTO permissions (id, url, name, pid)
VALUES (1, '/**', '', 0);
INSERT INTO permissions (id, url, name, pid)
VALUES (2, '/**', '', 0);

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_role (user_id, role_id)
VALUES (2, 2);

INSERT INTO role_permission (role_id, permission_id)
VALUES (1, 1);
INSERT INTO role_permission (role_id, permission_id)
VALUES (2, 2);