/* ###
 * IP: GHIDRA
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
package ghidra.app.util.pcodeInject;

import ghidra.app.plugin.processors.sleigh.SleighLanguage;
import ghidra.javaclass.format.constantpool.AbstractConstantPoolInfoJava;
import ghidra.program.model.lang.InjectContext;
import ghidra.program.model.listing.Program;

public class InjectInvokeVirtual extends InjectPayloadJava {

	public InjectInvokeVirtual(String sourceName, SleighLanguage language) {
		super(sourceName, language);
	}

	@Override
	public String getPcodeText(Program program, String context) {
		InjectContext injectContext = getInjectContext(program, context);
		AbstractConstantPoolInfoJava[] constantPool = getConstantPool(program);
		int constantPoolIndex = (int) injectContext.inputlist.get(0).getOffset();
		String pcodeText = InvokeMethods.getPcodeForInvoke(constantPoolIndex, constantPool, JavaInvocationType.INVOKE_VIRTUAL);
		return pcodeText;
	}

}
