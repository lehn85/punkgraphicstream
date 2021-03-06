/*
 * SubtitleEvent.java
 *
 * Copyright 2008 David Connolly. All rights reserved.
 *
 * This file is part of PunkGraphicStream.
 *
 * PunkGraphicStream is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 */
package name.connolly.david.pgs;

import java.awt.image.BufferedImage;

public class SubtitleEvent implements Comparable<SubtitleEvent> {

    private static int eventCount = 0;
    private Timecode timecode;
    private final long id;
    private SubtitleType type;
    private BufferedImage image;
    private int offsetX;
    private int offsetY;

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public SubtitleEvent(final Timecode timecode, final SubtitleType type) {
        this.timecode = timecode;
        this.type = type;
        id = eventCount;
        offsetX = 0;
        offsetY = 0;
        eventCount++;
    }

    public int compareTo(SubtitleEvent o) {
        return timecode.compareTo(o.timecode);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubtitleEvent other = (SubtitleEvent) obj;
        if (timecode == null) {
            if (other.timecode != null) {
                return false;
            }
        } else if (!timecode.equals(other.timecode)) {
            return false;
        }
        return true;
    }

    public long getId() {
        return id;
    }

    public long getRenderTimecode() {
        return timecode.getStart();
    }

    public Timecode getTimecode() {
        return timecode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (timecode == null ? 0 : timecode.hashCode());
        return result;
    }

    public void setType(SubtitleType type) {
        this.type = type;
    }

    public void setImage(final BufferedImage image) {
        if (this.image != null) {
            throw new RuntimeException("Image already initialized");
        }

        this.image = image;
    }

    public void setTimecode(Timecode timecode) {
        this.timecode = timecode;
    }

    public BufferedImage getImage() throws InterruptedException {
        return image;
    }

    @Override
    public String toString() {
        return "SubtitleEvent id: " + id + " " + timecode.toString();
    }

    public SubtitleType getType() {
        return type;
    }

    public enum SubtitleType {

        FIRST, // One one SubtitleEvent for Native Event or First in Sequence
        SEQUENCE;   // Substitute start of subtitle for end of last subtitle + 1
    }

    public static void lastEvent() {
        eventCount = 0;
    }

    /*
     * Pending figuring out the format!
     */
    public void setClip(int minX, int minY, int maxX, int maxY) {
        int width = maxX - minX;
        int height = maxY - minY;
        int minimumSize = 503;

        if (width * height < minimumSize) {
            // rare case that would break quantizer
            // TODO: tweak the size of the clipping upwards, instead of skipping
            return;
        }

        offsetX = minX;
        offsetY = minY;

        image = image.getSubimage(minX, minY, width, height);
    }
}
