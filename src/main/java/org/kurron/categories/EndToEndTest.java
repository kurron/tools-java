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
 * Tests of these type are testing a fully running system with all dependencies running on the network.  Service
 * stubs are never in play in such configuration.  Typically, only a handful of end-to-end test exist due to
 * the difficulty in getting all collaborating services up and running.
 */
public interface EndToEndTest {
}
