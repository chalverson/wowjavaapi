/*
 * Copyright (c) 2011 Chris D. Halverson <cdh@halverson.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.halverson.wowapi.entity;

/**
 * Class to represent an error reponse. This will be checked first in the DAOs to see if there is an error. If this
 * is not valid, the DAO will continue on and try to parse the JSON into the representative class.
 * <p>
 * A typical error response is as follows: <code>{"status":"nok", "reason":"Character not found."}</code>
 */
public class BlizzardErrorResponse {
    private String status = "";
    private String reason = "";

    /**
     * Returns the status.
     * @return String from the status call.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the API call
     * @param status of the call
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the result text.
     * @return String containing the result text from the API.
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the reason code.
     * @param reason the call failed.
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BlizzardErrorResponse");
        sb.append("{status='").append(status).append('\'');
        sb.append(", reason='").append(reason).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
