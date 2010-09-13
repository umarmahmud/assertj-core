/*
 * Created on Sep 9, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.formatting;

import java.util.*;

/**
 * Returns the {@code String} representation of a {@code Object}, based on registered <code>{@link ToStringRule}</code>
 * s.
 * @author Alex Ruiz
 */
public class ToStringConverter {

  private final Collection<ToStringRule> rules = new HashSet<ToStringRule>();
  private final ToStringRule defaultRule = new ObjectToStringRule();

  private static final ToStringConverter INSTANCE = new ToStringConverter();

  /**
   * Returns the singleton instance of this class.
   * @return the singleton instance of this class.
   */
  public static ToStringConverter instance() {
    return INSTANCE;
  }

  private ToStringConverter() {
    rules.add(new ArrayToStringRule());
    rules.add(new ClassToStringRule());
    rules.add(new CollectionToStringRule());
    rules.add(new FileToStringRule());
    rules.add(new MapToStringRule());
    rules.add(new StringToStringRule());
  }

  /**
   * Returns the {@code String} representation of the given {@code Object}. If this converter does not any special
   * rule to obtain the {@code String} representation, it will use call the given {@code Object}'s {@code toString}.
   * @param o the given {@code Object}.
   * @return the {@code String} representation of the given {@code Object}, or {@code null} if the given {@code Object}
   * is {@code null}.
   */
  public String toStringOf(Object o) {
    if (o == null) return defaultToString(o);
    for (ToStringRule rule : rules)
      if (rule.canHandle(o)) return rule.toStringOf(o);
    return defaultToString(o);
  }

  private String defaultToString(Object o) {
    return defaultRule.toStringOf(o);
  }
}
