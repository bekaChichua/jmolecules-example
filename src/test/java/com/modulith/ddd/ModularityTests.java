/*
 * Copyright 2022-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.modulith.ddd;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import org.jmolecules.archunit.JMoleculesDddRules;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

/**
 * Verifying modulithic structure and creating documentation for {@link ApplicationModules}.
 *
 * @author Oliver Drotbohm
 */

@AnalyzeClasses(packages = "com.modulith.ddd")
class ModularityTests {

	ApplicationModules modules = ApplicationModules.of(DddApplication.class);

	@Test
	void verifiesArchitecture() {

		// System.out.println(modules);

		modules.verify();

	}

	@ArchTest
	void whenCheckingAllClasses_thenCodeFollowsAllDddPrinciples(JavaClasses classes) {
		JMoleculesDddRules.all().check(classes);
	}

	@Test
	void createDocumentation() {
		new Documenter(modules).writeDocumentation();
	}
}
