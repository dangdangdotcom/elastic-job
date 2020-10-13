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

package org.apache.shardingsphere.elasticjob.error.handler.dingtalk;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Properties;

@Getter
@RequiredArgsConstructor
public final class DingtalkConfiguration {
    
    private static final String PREFIX = "dingtalk.";
    
    private final String webhook;
    
    private final String keyword;
    
    private final String secret;
    
    private final Integer connectTimeout;
    
    private final Integer readTimeout;
    
    /**
     * Get dingtalk config.
     *
     * @param props props
     * @return dingtalk config.
     */
    public static DingtalkConfiguration getByProps(final Properties props) {
        return new DingtalkConfiguration(props.getProperty(PREFIX.concat("webhook")),
                props.getProperty(PREFIX.concat("keyword")), props.getProperty(PREFIX.concat("secret")),
                Integer.valueOf(props.getOrDefault(PREFIX.concat("connectTimeout"), 3000).toString()),
                Integer.valueOf(props.getOrDefault(PREFIX.concat("readTimeout"), 5000).toString()));
    }
}
