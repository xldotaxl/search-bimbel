package it.aldi.app.domain.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RoleEnum {
    SUPERADMIN, OWNER, STUDENT, TUTOR;

    public static List<String> excludeSuperAdmin() {
        return Stream.of(RoleEnum.values())
            .filter(RoleEnum::isNotSuperAdmin)
            .map(RoleEnum::name)
            .collect(Collectors.toList());
    }

    private static boolean isNotSuperAdmin(RoleEnum roleEnum) {
        return !SUPERADMIN.equals(roleEnum);
    }
}
