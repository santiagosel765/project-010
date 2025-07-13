INSERT INTO user_status (status_id, name, description) VALUES
                                                           (1, 'ACTIVE', 'Usuario activo'),
                                                           (2, 'INACTIVE', 'Usuario inactivo');

INSERT INTO auth_role (id, name, description, status) VALUES
                                                          (1, 'USER', 'Rol por defecto para usuarios', 1),
                                                          (2, 'ADMIN', 'Administrador del sistema', 1);
