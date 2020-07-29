/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2020 the original author or authors.
 */
package org.assertj.core.condition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.condition.DoesNotHave.doesNotHave;

import org.assertj.core.api.Condition;
import org.assertj.core.api.TestCondition;
import org.junit.jupiter.api.Test;


/**
 * Tests for <code>{@link DoesNotHave#doesNotHave(Condition)}</code>.
 * 
 * @author Nicolas François
 */
class DoesNotHave_with_condition_Test {

  @Test
  void should_create_new_doesNotHave_with_passed_Condition() {
    TestCondition<Object> condition = new TestCondition<>();
    Condition<Object> created = doesNotHave(condition);
    assertThat(created.getClass()).isEqualTo(DoesNotHave.class);
    DoesNotHave<Object> doesNotHave = (DoesNotHave<Object>) created;
    assertThat(doesNotHave.condition).isEqualTo(condition);
  }

}
