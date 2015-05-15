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

package org.kurron.stereotype;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Just to prove that the custom annotations play well with the current release of Spring.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ActiveProfiles( "use-stubs" )
@ContextConfiguration( classes = SpringContext.class )
public class StubSanityCheck {

    /**
     * Subject under test.
     */
    @Autowired
    private ServiceContract sut;

    @Test
    public void sanityCheck() throws Exception {
        assert null != sut;
        assert "Hello from the stubbed service".equalsIgnoreCase( sut.hello() );
    }
}
