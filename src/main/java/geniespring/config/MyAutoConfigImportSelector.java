package geniespring.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    // 동적인 자동 구성 정보 등록
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "geniespring.config.autoconfig.DispatcherServletConfig",
                "geniespring.config.autoconfig.TomcatWebServerConfig",
        };
    }
}
