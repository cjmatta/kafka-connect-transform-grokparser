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

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class GrokParserConfig extends AbstractConfig {

    public static final String FIELD_CONF = "field";
    static final String FIELD_DOC = "The field in the record to parse.";
    static final String FIELD_DEFAULT = "";

    public static final String GROK_PATTERN = "grok.pattern";
    static final String GROK_PATTERN_DOC = "The Grok pattern to parse with";
    static final String GROK_PATTERN_DEFAULT = "";

    public final String fieldConf;
    public final String grokPattern;

    public GrokParserConfig(Map<String, ?> parsedConfig) {
        super(config(), parsedConfig);
        this.fieldConf = getString(FIELD_CONF);
        this.grokPattern = getString(GROK_PATTERN);
    }

    static ConfigDef config() {
        return new ConfigDef()
            .define(FIELD_CONF, ConfigDef.Type.STRING, FIELD_DEFAULT, ConfigDef.Importance.HIGH, FIELD_DOC)
            .define(GROK_PATTERN, ConfigDef.Type.STRING, GROK_PATTERN_DEFAULT, ConfigDef.Importance.HIGH, GROK_PATTERN_DOC);
    }
}
