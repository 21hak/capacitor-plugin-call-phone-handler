declare module '@capacitor/core' {
  interface PluginRegistry {
    CallPhoneHandler: CallPhoneHandlerPlugin;
  }
}

export interface CallPhoneHandlerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  callPhone(options: { phoneNumber: string }): Promise<void>;
}
