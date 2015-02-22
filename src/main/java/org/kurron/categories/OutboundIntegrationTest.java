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
 * Tests that are marked like this are testing the integration points used by the outbound
 * gateways, such as REST endpoints or the database.  In terms of Spring, these type of tests normally
 * do not require the entire application to be stood up and listening on a port.  Normally, just enough
 * of the Spring context needs to be loaded to obtain properties sufficient the configure REST templates or
 * database connections.
 */
public interface OutboundIntegrationTest {
}
