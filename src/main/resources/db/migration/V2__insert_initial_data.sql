INSERT INTO user_status (status_id, name, description) VALUES
                                                           (1, 'ACTIVE', 'Usuario activo'),
                                                           (2, 'INACTIVE', 'Usuario inactivo');

INSERT INTO auth_role (id, name, description, status) VALUES
                                                          (1, 'USER', 'Rol por defecto para usuarios', 1),
                                                          (2, 'ADMIN', 'Administrador del sistema', 1);

-- default modules
INSERT INTO auth_module (id, name, description, status) VALUES
    (1, 'INVENTORY', 'Inventory Module', 1),
    (2, 'CLIENT', 'Client Module', 1),
    (3, 'PROVIDER', 'Provider Module', 1),
    (4, 'QUOTE', 'Quote Module', 1),
    (5, 'PURCHASE', 'Purchase Module', 1);

-- assign modules to admin role
INSERT INTO auth_role_module (auth_role_id, auth_module_id, status) VALUES
    (2, 1, 1),
    (2, 2, 1),
    (2, 3, 1),
    (2, 4, 1),
    (2, 5, 1);
