package geniespring.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
    // 동적인 자동 구성 정보 등록
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 자동 구성 정보의 후보들을 읽어 들어오기
//        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
//        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);

        List<String> autoConfigs = new ArrayList<>();
//        for(String candidate: ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//            autoConfigs.add(candidate);
//        }

        // fileName: META-INF/spring/full-qualified-annotation-name.imports
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);

        return autoConfigs.toArray(new String[0]); // 사이즈를 몰라서, Empty를 넣자.
    }
}
