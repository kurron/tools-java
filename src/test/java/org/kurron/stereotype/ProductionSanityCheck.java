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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Just to prove that the custom annotations play well with the current release of Spring.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ActiveProfiles( "use-stubs" )
@ContextConfiguration( classes = SpringContext.class )
public class ProductionSanityCheck {

    /**
     * Logger to exercise.
     */
    private static final Logger log =  org.slf4j.LoggerFactory.getLogger( ProductionSanityCheck.class );

    /**
     * Subject under test.
     */
    @Autowired
    @Qualifier( "production" )
    private ServiceContract sut;

    @BeforeClass
    public static void before() {
        MDC.put( "message-code", Integer.toString( 1999 ) );
        MDC.put( "service-code", "Thor" );
        MDC.put( "service-instance", Integer.toString( 1995 ) );
        MDC.put( "realm", "Nashua Endurance Lab" );
        MDC.put( "correlation-id", "BEEFBABE" );
    }

    @AfterClass
    public static void after() {
        MDC.clear();
    }

    @Test
    public void sanityCheck() throws Exception {

        assert null != sut;
        assert "Hello from the production service".equalsIgnoreCase( sut.hello() );
    }

    @Test
    public void jsonLogging() throws Exception {

        // Silly test just to see how the logged JSON is formed
        log.debug( "Ron was here." );
        try {
            throw new RuntimeException( "Forced to fail." );
        }
        catch ( final RuntimeException e ) {
            log.error( "Logan was here." );
            // this form won't log for some reason
            log.error( "Logan was here.", new RuntimeException( "Forced to fail." ) );
        }
    }
}
