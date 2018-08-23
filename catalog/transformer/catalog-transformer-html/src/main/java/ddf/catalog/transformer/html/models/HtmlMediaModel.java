/**
 * Copyright (c) Codice Foundation
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package ddf.catalog.transformer.html.models;

import java.util.Base64;

public class HtmlMediaModel extends HtmlValueModel {
  private String data;

  private static final String MEDIA_ATTRIBUTE_TEMPLATE = "mediaAttribute";

  public HtmlMediaModel(byte[] rawData) {
    super(MEDIA_ATTRIBUTE_TEMPLATE);
    this.data = getEncodedThumbnail(rawData);
  }

  private String getEncodedThumbnail(byte[] rawData) {
    if (rawData == null) {
      return null;
    }

    byte[] encoded = Base64.getEncoder().encode(rawData);
    return new String(encoded);
  }

  @Override
  public String getValue() {
    return this.data;
  }
}
