/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.elasticjob.error.handler.general;

import org.apache.shardingsphere.elasticjob.error.handler.general.impl.LogJobErrorHandler;
import org.apache.shardingsphere.elasticjob.error.handler.general.impl.ThrowJobErrorHandler;
import org.apache.shardingsphere.elasticjob.infra.exception.JobConfigurationException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public final class JobErrorHandlerFactoryTest {
    
    @Test
    public void assertGetDefaultHandler() {
        assertThat(JobErrorHandlerFactory.getHandler(""), instanceOf(LogJobErrorHandler.class));
    }
    
    @Test(expected = JobConfigurationException.class)
    public void assertGetInvalidHandler() {
        JobErrorHandlerFactory.getHandler("INVALID");
    }
    
    @Test
    public void assertGetHandler() {
        assertThat(JobErrorHandlerFactory.getHandler("THROW"), instanceOf(ThrowJobErrorHandler.class));
    }
}