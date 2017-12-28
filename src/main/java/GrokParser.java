/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import io.thekraken.grok.api.Grok;
import io.thekraken.grok.api.Match;
import io.thekraken.grok.api.exception.GrokException;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.ConnectRecord;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.transforms.Transformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class GrokParser <R extends ConnectRecord<R>> implements Transformation<R> {
    private static final Logger log = LoggerFactory.getLogger(GrokParser.class);
    GrokParserConfig config;

    @Override
    public R apply(R r) {
        return null;
    }

    @Override
    public ConfigDef config() {
        return null;
    }

    @Override
    public void configure(Map<String, ?> map) {

    }

    @Override
    public void close() {

    }

    private Struct parseLine (String line) throws GrokException {
        Grok grok = Grok.create("patterns/patterns");

        grok.compile(this.config.grokPattern);
        Match gm = grok.match(line);

        return new Struct(new Schema() {
            @Override
            public Type type() {
                return null;
            }

            @Override
            public boolean isOptional() {
                return false;
            }

            @Override
            public Object defaultValue() {
                return null;
            }

            @Override
            public String name() {
                return null;
            }

            @Override
            public Integer version() {
                return null;
            }

            @Override
            public String doc() {
                return null;
            }

            @Override
            public Map<String, String> parameters() {
                return null;
            }

            @Override
            public Schema keySchema() {
                return null;
            }

            @Override
            public Schema valueSchema() {
                return null;
            }

            @Override
            public List<Field> fields() {
                return null;
            }

            @Override
            public Field field(String s) {
                return null;
            }

            @Override
            public Schema schema() {
                return null;
            }
        });
    }
}
