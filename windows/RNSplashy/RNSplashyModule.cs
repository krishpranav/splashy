using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Splashy.RNSplashy
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNSplashyModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNSplashyModule"/>.
        /// </summary>
        internal RNSplashyModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNSplashy";
            }
        }
    }
}
