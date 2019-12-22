/*
 * Copyright 2018-2050 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geercode.creed.core.lang;

import java.io.Serializable;

/**
 * <p>Description : 版本号</p>
 * <p>Created on  : 2019-03-07 14:58</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class Version implements Serializable {
    private static final long serialVersionUID = 4652990795044243501L;
    private final int major;
    private final int minor;
    private final int micro;

    /**
     * <p>description : 构造器</p>
     * <p>create   on : 2019-03-07 15:54:21</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    public Version(int major, int minor, int micro) {
        this.major = major;
        this.minor = minor;
        this.micro = micro;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getMicro() {
        return micro;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Version other = (Version) obj;
            if (this.major != other.getMajor()) {
                return false;
            } else if (this.minor != other.getMinor()) {
                return false;
            } else if (this.micro != other.getMicro()) {
                return false;
            }
            return true;
        }
    }

    @Override
    public String toString() {
        return "" + major + "." + minor + "." + micro;
    }
}