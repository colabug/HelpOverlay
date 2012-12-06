package com.colabug.help;

import android.view.View;
import android.widget.TextView;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Author: Corey Leigh Latislaw
 * Date: 12/6/12
 * Purpose:
 */
@RunWith (RobolectricTestRunner.class)
public class HelpOverlayActivityTest
{
    private HelpOverlayActivity helpOverlayActivity;

    private TextView helpButton;

    @Before
    public void setUp() throws Exception
    {
        helpOverlayActivity = new HelpOverlayActivity();
        helpOverlayActivity.onCreate( null );

        helpButton = (TextView) helpOverlayActivity.findViewById( R.id.help_button );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( helpOverlayActivity );
    }

    @Test
    public void shouldHaveHelpButton() throws Exception
    {
        assertViewIsVisible( helpButton );
    }

    @Test
    public void shouldHaveHelpButtonText() throws Exception
    {
        assertThat( helpButton.getText().toString(),
                    equalTo( getResourceString( R.string.HELP_BUTTON_TEXT ) ) );
    }

    @Test
    public void helpButtonShouldShowHelpOverlay() throws Exception
    {
        helpButton.performClick();
        assertViewIsVisible( helpOverlayActivity.findViewById( R.id.help_overlay ) );

        // Check text
        TextView helpOverlayText = (TextView) helpOverlayActivity.findViewById( R.id.help_text );
        assertViewIsVisible( helpOverlayText );
        assertThat( helpOverlayText.getText().toString(),
                    equalTo( getResourceString( R.string.HELP_STRING ) ) );
    }

    @Test
    public void helpOverlayShouldDismissOnTouch() throws Exception
    {
        helpButton.performClick();
        View overlay = helpOverlayActivity.findViewById( R.id.help_overlay );
        overlay.performClick();
        View overlay2 = helpOverlayActivity.findViewById( R.id.help_overlay );
        assertNull( overlay2 );
    }

    private String getResourceString( int resourceId )
    {
        return Robolectric.application.getApplicationContext().getString( resourceId );
    }

    public static void assertViewIsVisible( View view )
    {
        assertNotNull( view );
        assertThat( view.getVisibility(), equalTo( View.VISIBLE ) );
    }
}
