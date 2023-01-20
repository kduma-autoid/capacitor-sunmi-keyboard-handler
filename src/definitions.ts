export interface SunmiKeyboardHandlerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
