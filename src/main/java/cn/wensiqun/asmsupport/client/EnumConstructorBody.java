/**    
 *  Asmsupport is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cn.wensiqun.asmsupport.client;

import cn.wensiqun.asmsupport.client.def.var.LocVar;
import cn.wensiqun.asmsupport.core.block.method.init.EnumConstructorBodyInternal;
import cn.wensiqun.asmsupport.core.definition.variable.LocalVariable;
import cn.wensiqun.asmsupport.standard.method.IEnumConstructorBody;

public abstract class EnumConstructorBody extends ProgramBlock<EnumConstructorBodyInternal> implements IEnumConstructorBody<LocVar> {

	public EnumConstructorBody() {
		target = new EnumConstructorBodyInternal(){

			@Override
			public void body(LocalVariable... args) {
				EnumConstructorBody.this.body(internalVar2ClientVar(args));
			}
			
		};
	}
}
