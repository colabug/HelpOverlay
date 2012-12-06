package com.colabug.help;

import android.widget.TextView;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    private TextView welcome;

    @Before
    public void setUp() throws Exception
    {
        helpOverlayActivity = new HelpOverlayActivity();
        helpOverlayActivity.onCreate( null );

        welcome = (TextView) helpOverlayActivity.findViewById( R.id.welcome_string );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( helpOverlayActivity );
    }

    @Test
    public void shouldHaveWelcomeString() throws Exception
    {
        assertNotNull( welcome );
    }

    @Test
    public void shouldHaveCorrectWelcomeString() throws Exception
    {
        assertThat( welcome.getText().toString(),
                    equalTo( getResourceString( R.string.WELCOME_STRING )) );
    }

    private String getResourceString( int resourceId )
    {
        return Robolectric.application.getApplicationContext().getString( resourceId );
    }
}
