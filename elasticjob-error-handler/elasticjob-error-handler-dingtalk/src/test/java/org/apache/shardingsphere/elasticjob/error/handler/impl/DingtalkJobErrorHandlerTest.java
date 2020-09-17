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

package org.apache.shardingsphere.elasticjob.error.handler.impl;

import org.apache.shardingsphere.elasticjob.error.handler.env.DingtalkEnvironment;
import org.junit.Test;

public final class DingtalkJobErrorHandlerTest {
    
    @Test
    public void assertHandleException() {
        DingtalkJobErrorHandler actual = new DingtalkJobErrorHandler();
        Throwable cause = new RuntimeException("test");
        actual.handleException("test_job", cause);
    }
    
    @Test
    public void assertHandleExceptionWithSystemProperties() {
        System.getProperties().setProperty(DingtalkEnvironment.EnvironmentArgument.WEBHOOK.getKey(),
                "https://oapi.dingtalk.com/robot/send?access_token=42eead064e81ce81fc6af2c107fbe10a4339a3d40a7db8abf5b34d8261527a3f");
        System.getProperties().setProperty(DingtalkEnvironment.EnvironmentArgument.SECRET.getKey(),
                "SEC0b0a6b13b6823b95737dd83491c23adee5d8a7a649899a12217e038eddc84ff4");
        System.getProperties().setProperty(DingtalkEnvironment.EnvironmentArgument.KEYWORD.getKey(), "keyword1");
        DingtalkJobErrorHandler actual = new DingtalkJobErrorHandler();
        Throwable cause = new RuntimeException("test");
        actual.handleException("test_job", cause);
    }
    
}
