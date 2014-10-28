/***********************************************************************************

    Copyright (C) 2012-2014 Ahmet Öztürk (aoz_2@yahoo.com)

    This file is part of Lifeograph.

    Lifeograph is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Lifeograph is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Lifeograph.  If not, see <http://www.gnu.org/licenses/>.

 ***********************************************************************************/

package net.sourceforge.lifeograph;


import android.graphics.Color;

public class Theme {

    public static class System extends Theme {
        private System()
        {
            //font = ;
            color_base = "#FFFFFF";
            color_text = "#000000";
            color_heading = "#0000FF";
            color_subheading = "#F066FC";
            color_highlight = "#FFF955";
        }

        @Override
        public boolean is_system() {
            return true;
        }

        public static System get() {
            // initialize if not already initialized:
            if( system == null )
                system = new System();
            return system;
        }

        protected static System system = null;
    }

    public Theme() {
    }

    public Theme( Theme theme )
    {
        font = theme.font;
        color_base = theme.color_base;
        color_text = theme.color_text;
        color_heading = theme.color_heading;
        color_subheading = theme.color_subheading;
        color_highlight = theme.color_highlight;
    }

    public boolean is_system() {
        return false;
    }

    protected String font;
    protected String color_base;
    protected String color_text;
    protected String color_heading;
    protected String color_subheading;
    protected String color_highlight;

    private static int parse_color_sub( String color, int begin, int end ) {
        int ret_val = 0;

        for( int i = begin; i <= end; i++ ) {
            char c = color.charAt( i );
            if( c >= '0' && c <= '9' ) {
                ret_val *= 16;
                ret_val += ( c - '0' );
            }
            else if( c >= 'a' && c <= 'f' ) {
                ret_val *= 16;
                ret_val += ( c - 'a' + 10 );
            }
            else if( c >= 'A' && c <= 'F' ) {
                ret_val *= 16;
                ret_val += ( c - 'A' + 10 );
            }
        }

        return ret_val;
    }

    public static int parse_color( String color ) {
        return Color.rgb( parse_color_sub( color, 1, 2 ),
                          parse_color_sub( color, 5, 6 ),
                          parse_color_sub( color, 9, 10 ) );
    }
    public static String color2string( int i_color ) {
        return String.format( "#%02X%<02X%02X%<02X%02X%<02X",
                              Color.red( i_color ),
                              Color.green( i_color ),
                              Color.blue( i_color ) );
    }
}
