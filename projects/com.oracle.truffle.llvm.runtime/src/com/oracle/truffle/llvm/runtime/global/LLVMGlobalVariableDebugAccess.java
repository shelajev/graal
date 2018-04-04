/*
 * Copyright (c) 2017, Oracle and/or its affiliates.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.truffle.llvm.runtime.global;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.llvm.runtime.LLVMAddress;
import com.oracle.truffle.llvm.runtime.LLVMContext;

public final class LLVMGlobalVariableDebugAccess {

    public static boolean isInitialized(LLVMContext context, LLVMGlobal global) {
        return context.getGlobalFrame().getValue(global.getSlot()) != null;
    }

    public static boolean isInNative(LLVMContext context, LLVMGlobal global) {
        return context.getGlobalFrame().getValue(global.getSlot()) instanceof LLVMAddress;
    }

    public static LLVMAddress getNativeLocation(LLVMContext context, LLVMGlobal global) {
        if (!isInNative(context, global)) {
            CompilerDirectives.transferToInterpreter();
            throw new IllegalStateException("Global is not in native memory!");
        }
        return (LLVMAddress) context.getGlobalFrame().getValue(global.getSlot());
    }

    public static Object getManagedValue(LLVMContext context, LLVMGlobal global) {
        if (isInNative(context, global)) {
            CompilerDirectives.transferToInterpreter();
            throw new IllegalStateException("Global is not managed!");
        }
        return context.getGlobalFrame().getValue(global.getSlot());
    }
}
