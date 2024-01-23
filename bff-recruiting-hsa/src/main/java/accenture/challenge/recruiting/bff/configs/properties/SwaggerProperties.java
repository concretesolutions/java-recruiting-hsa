package accenture.challenge.recruiting.bff.configs.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Delegate;

@Getter
@Setter
public class SwaggerProperties {

    @Delegate
    private SwaggerUiEnabled ui;

    @Delegate
    private SwaggerInfo info;

    @Getter
    @Setter
    private static class SwaggerUiEnabled {
        private boolean enabled;
    }

    @Getter
    @Setter
    private static class SwaggerInfo {
        private String name;
        private String description;
        private String version;
        private SwaggerInfoContact contact;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SwaggerInfoContact {
        private String name;
        private String mail;
    }

}