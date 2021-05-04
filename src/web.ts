import { WebPlugin } from '@capacitor/core';
import { CallPhoneHandlerPlugin } from './definitions';

export class CallPhoneHandlerWeb
  extends WebPlugin
  implements CallPhoneHandlerPlugin {
  constructor() {
    super({
      name: 'CallPhoneHandler',
      platforms: ['web'],
    });
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async callPhone(options: { phoneNumber: string }) {
    window.open(`tel:${options.phoneNumber}`);
  }
}

const CallPhoneHandler = new CallPhoneHandlerWeb();

export { CallPhoneHandler };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(CallPhoneHandler);
