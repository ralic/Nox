/*
 * Copyright (C) 2015 Pedro Vicente Gomez Sanchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pedrovgs.nox.sample;

import com.github.pedrovgs.nox.path.Path;
import com.github.pedrovgs.nox.path.PathConfig;

/**
 * Vertical linear Path implementation used to place NoxItem objects in a single vertical line in
 * NoxView starting from the top of the view. NoxItem instances in this path will be centered.
 *
 * @author Pedro Vicente Gomez Sanchez.
 */
public class VerticalLinearPath extends Path {

  public VerticalLinearPath(PathConfig pathConfig) {
    super(pathConfig);
  }

  @Override public void calculate() {
    int numberOfElements = getNumberOfElements();
    PathConfig pc = getPathConfig();
    float centerX = pc.getViewWidth() / 2 - pc.getItemSize() / 2;
    float y = getFirstElementPosition();
    for (int position = 0; position < numberOfElements; position++) {
      setNoxItemXPosition(position, centerX);
      setNoxItemYPosition(position, y);
      y += pc.getItemSize() + pc.getItemMargin();
    }
  }

  private float getFirstElementPosition() {
    float center = getPathConfig().getViewHeight() / 2;
    int numberOfElements = getNumberOfElements();
    float itemSize = getPathConfig().getItemSize();
    float itemMargin = getPathConfig().getItemMargin();
    return center - numberOfElements * (itemSize / 2 + itemMargin / 2);
  }
}