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
package cn.wensiqun.asmsupport.core.utils.memory;


import cn.wensiqun.asmsupport.org.objectweb.asm.Type;

/**
 * Represent an element that's should be push to {@link OperandStack}
 * 
 * @author wensiqun at 163.com(Joe Wen)
 */
public class OperandType {
    
    private Type type;

    public OperandType(Type type) {
        this.type = type;
    }

    /**
     * Get the element type.
     */
    public Type getType(){
        return type;
    }

    /**
     * Get the element size in stack
     */
    public int getSize() {
        return type.getSize();
    }
}
