/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sshd.common.forward;


import java.io.IOException;

import org.apache.sshd.common.Closeable;
import org.apache.sshd.common.util.net.SshdSocketAddress;

public interface TcpipForwarder extends PortForwardingManager, PortForwardingEventListenerManager, Closeable {
    /**
     * @param remotePort The remote port
     * @return The local {@link SshdSocketAddress} that the remote port is forwarded to
     */
    SshdSocketAddress getForwardedPort(int remotePort);

    /**
     * Called when the other side requested a remote port forward.
     *
     * @param local The request address
     * @return The bound local {@link SshdSocketAddress} - {@code null} if not allowed to forward
     * @throws IOException If failed to handle request
     */
    SshdSocketAddress localPortForwardingRequested(SshdSocketAddress local) throws IOException;

    /**
     * Called when the other side cancelled a remote port forward.
     *
     * @param local The local {@link SshdSocketAddress}
     * @throws IOException If failed to handle request
     */
    void localPortForwardingCancelled(SshdSocketAddress local) throws IOException;
}
