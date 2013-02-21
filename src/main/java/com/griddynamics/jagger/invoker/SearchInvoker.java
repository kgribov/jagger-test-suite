/*
 * Copyright (c) 2010-2012 Grid Dynamics Consulting Services, Inc, All Rights Reserved
 * http://www.griddynamics.com
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.griddynamics.jagger.invoker;

import org.apache.commons.httpclient.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchInvoker implements Invoker<String, Integer, String> {
    private static final Logger log = LoggerFactory.getLogger(SearchInvoker.class);

    private final String GOOGLE_SEARCH_PATH="/#output=search&q=";
    private final String YANDEX_SEARCH_PATH ="/yandsearch?text=";

    private HttpClient httpClient = new HttpClient();

    private String getPath(String endpoint, String searchString) {
        /*if (endpoint.contains("google")) {
            return GOOGLE_SEARCH_PATH + searchString;
        } else if (endpoint.contains("ya")) {
            return YANDEX_SEARCH_PATH + searchString;
        } else {
            return "";
        }*/
        return "";
    }

    @Override
    public final Integer invoke(String query, String endpoint) throws InvocationException {
       /* Preconditions.checkNotNull(query);
        Preconditions.checkNotNull(endpoint);

        HttpMethod method = new GetMethod(endpoint);
        method.setPath(getPath(endpoint, query));

        try {
            int returnCode = httpClient.executeMethod(method);

            return returnCode;
        } catch (HttpException e) {
            log.debug("Error during invocation", e);
            throw new InvocationException("InvocationException : ", e);
        } catch (IOException e) {
            log.debug("Error during invocation", e);
            throw new InvocationException("InvocationException : ", e);
        } finally {
            try {
                method.releaseConnection();
            } catch (Throwable e) {
                log.error("Cannot release connection", e);
            }
        }*/
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Apache Commons Http Invoker";
    }
}
