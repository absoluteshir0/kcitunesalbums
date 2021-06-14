package sn.nino.kcitunesalbums.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import sn.nino.kcitunesalbums.api.Results
import sn.nino.kcitunesalbums.db.Session

class LoadActivity {
    companion object {
        fun goTo(context: Context, activity: Class<*>?){
            context.startActivity(Intent(context, activity))
        }

        fun goTo(context: Context, activity: Class<*>?, session: Session){
            val intent = Intent(context, activity)
            intent.putExtra(Constants.KEY_SESSION, session)
            context.startActivity(intent)
        }

        fun goTo(context: Context, activity: Class<*>?, results: Results){
            val intent = Intent(context, activity)
            intent.putExtra(Constants.KEY_RESULTS, results)
            context.startActivity(intent)
        }
    }
}