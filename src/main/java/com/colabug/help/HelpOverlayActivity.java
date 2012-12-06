package com.colabug.help;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class HelpOverlayActivity extends Activity
{
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        Button helpButton = (Button) findViewById( R.id.help_button );
        helpButton.setOnClickListener( createHelpButtonClickListener() );
    }

    private View.OnClickListener createHelpButtonClickListener()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                showHelp();
            }
        };
    }

    private void showHelp()
    {
        // Inflate & add help view
        final FrameLayout main = (FrameLayout) findViewById( R.id.main_view );
        LayoutInflater inflater = LayoutInflater.from( getApplicationContext() );
        final RelativeLayout help = (RelativeLayout) inflater.inflate( R.layout.overlay, null );
        main.addView( help );

        // Set on click listener to exit tutorial
        help.setOnClickListener( new View.OnClickListener()
        {
            public void onClick( View v )
            {
                main.removeViewAt( main.getChildCount() - 1 );
            }
        } );
    }
}
