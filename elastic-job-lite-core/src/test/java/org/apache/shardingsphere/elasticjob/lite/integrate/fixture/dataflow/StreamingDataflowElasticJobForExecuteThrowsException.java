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

package org.apache.shardingsphere.elasticjob.lite.integrate.fixture.dataflow;

import lombok.Getter;
import org.apache.shardingsphere.elasticjob.lite.api.job.ShardingContext;
import org.apache.shardingsphere.elasticjob.lite.api.job.type.DataflowJob;
import org.apache.shardingsphere.elasticjob.lite.exception.JobSystemException;

import java.util.Collections;
import java.util.List;

@Getter
public final class StreamingDataflowElasticJobForExecuteThrowsException implements DataflowJob<String> {
    
    private volatile boolean completed;
    
    @Override
    public List<String> fetchData(final ShardingContext shardingContext) {
        if (completed) {
            return null;
        }
        return Collections.singletonList("data");
    }
    
    @Override
    public void processData(final ShardingContext shardingContext, final List<String> data) {
        completed = true;
        throw new JobSystemException("I want an error.");
    }
}
