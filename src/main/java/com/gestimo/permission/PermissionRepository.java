package com.gestimo.permission;

import java.util.Optional;

public interface PermissionRepository {
    Optional<Permission> findByNomPermission(String nomPermission);
}
