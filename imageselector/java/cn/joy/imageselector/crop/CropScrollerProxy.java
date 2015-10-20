/*******************************************************************************
 * Copyright  2015 Albin Mathew.
 *  <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package cn.joy.imageselector.crop;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;

abstract class CropScrollerProxy {

   public static CropScrollerProxy getScroller(Context context) {
	   if (VERSION.SDK_INT < VERSION_CODES.GINGERBREAD) {
		   return new CropPreGingerScroller(context);
	   } else if (VERSION.SDK_INT < VERSION_CODES.ICE_CREAM_SANDWICH) {
		   return new CropGingerScroller(context);
	   } else {
		   return new CropIcsScroller(context);
	   }
   }

   public abstract boolean computeScrollOffset();

   public abstract void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY,
							  int maxY, int overX, int overY);

   public abstract void forceFinished(boolean finished);

   public abstract boolean isFinished();

   public abstract int getCurrX();

   public abstract int getCurrY();


}