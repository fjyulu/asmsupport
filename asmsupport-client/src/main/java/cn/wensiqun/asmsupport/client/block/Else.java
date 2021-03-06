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
package cn.wensiqun.asmsupport.client.block;

import cn.wensiqun.asmsupport.core.block.control.condition.KernelElse;
import cn.wensiqun.asmsupport.standard.block.branch.IElse;

public abstract class Else extends ProgramBlock<KernelElse> implements IElse  {

	public Else() {
		setKernelBlock(new KernelElse() {
			@Override
			public void body() {
				Else.this.body();
			}
		});
	}
	
}
