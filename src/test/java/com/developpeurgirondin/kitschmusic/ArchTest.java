package com.developpeurgirondin.kitschmusic;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.developpeurgirondin.kitschmusic");

        noClasses()
            .that()
            .resideInAnyPackage("com.developpeurgirondin.kitschmusic.service..")
            .or()
            .resideInAnyPackage("com.developpeurgirondin.kitschmusic.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.developpeurgirondin.kitschmusic.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
