/*
 * Copyright (c) 2015 Ronald D. Kurr kurr@jvmguy.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kurron.categories;

/**
 * Tests of these types are testing multiple non-gateway objects.  That is to say, the objects that do not communicate
 * outside of the process.  Although all components, by definition, operate in-process only there are typically
 * fewer component tests in a system due to the orchestration needed to get multiple components properly configured
 * and wired together.
 */
public interface ComponentTest {
}
