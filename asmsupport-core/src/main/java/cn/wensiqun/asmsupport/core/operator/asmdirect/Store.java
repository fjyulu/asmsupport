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
package cn.wensiqun.asmsupport.core.operator.asmdirect;

import cn.wensiqun.asmsupport.core.block.KernelProgramBlock;
import cn.wensiqun.asmsupport.core.definition.variable.LocalVariable;

/**
 * 
 * @author 温斯群(Joe Wen)
 *
 */
public class Store extends ASMDirect {

    private LocalVariable var;
    
    protected Store(KernelProgramBlock block, LocalVariable var) {
        super(block);
        this.var = var;
    }

    @Override
    protected void doExecute() {
        insnHelper.storeInsn(var);
    }

}