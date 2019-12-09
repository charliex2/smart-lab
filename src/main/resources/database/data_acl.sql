INSERT INTO users (id, username, password)
VALUES (1, 'user', '{noop}test');
INSERT INTO users (id, username, password)
VALUES (2, 'admin', '{noop}test');

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